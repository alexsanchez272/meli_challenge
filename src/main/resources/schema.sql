
CREATE TABLE public.item_cache
(
	id serial NOT NULL,
    item_info jsonb NOT NULL,
    creation_date timestamp without time zone NOT NULL,
    response_time bigint NOT NULL,
    CONSTRAINT cache_pkey PRIMARY KEY (id)
);

CREATE TABLE public.ml_api_data
(
    id serial NOT NULL,
    item_cache_id integer NOT NULL,
    meli_api_response_time bigint,
    meli_api_status_code integer,
    PRIMARY KEY (id),
    CONSTRAINT ml_api_data_item_cache_fk FOREIGN KEY (item_cache_id)
        REFERENCES public.item_cache (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE public.metric
(
    id serial NOT NULL,
    metric_inf jsonb,
    CONSTRAINT metric_pkey PRIMARY KEY (id)
)