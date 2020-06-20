CREATE TABLE public.item_cache
(
    id serial NOT NULL,
    item_info jsonb NOT NULL,
    CONSTRAINT cache_pkey PRIMARY KEY (id)
);

CREATE TABLE public.api_data
(
    id serial NOT NULL,
    item_cache_id integer,
    creation_date timestamp without time zone,
    response_time bigint,
    CONSTRAINT api_data_pkey PRIMARY KEY (id),
    CONSTRAINT api_data_item_cache_fk FOREIGN KEY (item_cache_id)
        REFERENCES public.item_cache (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
    
CREATE TABLE public.ml_api_data
(
    id serial NOT NULL,
    api_data_id integer NOT NULL,
    meli_api_response_time bigint,
    meli_api_status_code integer,
    CONSTRAINT ml_api_data_pkey PRIMARY KEY (id),
    CONSTRAINT ml_api_data_item_cache_fk FOREIGN KEY (api_data_id)
        REFERENCES public.api_data (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.metric
(
    id serial NOT NULL,
    metric_inf jsonb,
    CONSTRAINT metric_pkey PRIMARY KEY (id)
);

--METRIC FUNCTION
CREATE OR REPLACE FUNCTION metric() RETURNS void 
as $$
DECLARE
   start_time timestamp;
   current_tim timestamp;
   avg_response_time bigint;
   total_requests integer;
   avg_response_time_api_calls bigint;
   total_count_api_calls integer;
   ml_api_data_json jsonb;
   
BEGIN
start_time := DATE_TRUNC('minute', CURRENT_TIMESTAMP - interval '1 minutes');
current_tim := DATE_TRUNC('minute',CURRENT_TIMESTAMP);

Select AVG(m.meli_api_response_time),  COUNT(*) INTO avg_response_time_api_calls, total_count_api_calls
from api_data a join ml_api_data m on m.api_data_id = a.id 
where a.creation_date BETWEEN start_time and current_tim;

Select AVG(a.response_time),  COUNT(*) INTO avg_response_time, total_requests
from api_data a
where a.creation_date BETWEEN start_time and current_tim;


select row_to_json(z) INTO ml_api_data_json
from (
  select to_char(current_tim, 'YYYY-MM-DD"T"HH24:MI:SS.MS') as date, avg_response_time, total_requests, avg_response_time_api_calls, total_count_api_calls,
    (
      select json_agg(json_build_object('status_code', t.meli_api_status_code, 'count', t.cantidad)) 
		FROM(
			SELECT meli_api_status_code, COUNT (*) as cantidad
			FROM ml_api_data group by meli_api_status_code)t
      ) info_requests
    ) as z;

INSERT INTO metric (metric_inf) VALUES(ml_api_data_json);
raise notice 'Value: %', ml_api_data_json;

END 
$$ language plpgsql;

-- Delete old data every day at 00:00:00
SELECT cron.schedule('0 00 * * *', $$DELETE FROM item_cache WHERE event_time < now() - interval '1 week'$$);

-- Generate metric every minute
SELECT cron.schedule('1 * * * *', $$SELECT metric()$$);

