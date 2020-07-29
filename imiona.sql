--psql -U postgres -d postgres -a -f imiona.sql
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

CREATE TABLE public.imiona (
                               name character varying(15),
                               count integer,
                               sex character(1),
                               description character varying(1000),
                               id serial NOT NULL
);


ALTER TABLE public.imiona OWNER TO postgres;


CREATE SEQUENCE public.imiona_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.imiona_id_seq OWNER TO postgres;

ALTER SEQUENCE public.imiona_id_seq OWNED BY public.imiona.id;



ALTER TABLE ONLY public.imiona ALTER COLUMN id SET DEFAULT nextval('public.imiona_id_seq'::regclass);



COPY public.imiona (name, count, sex, description, id) FROM stdin;
Piotr	5608	M	Piotr to przydomek nadany przez Chrystusa apostołowi Szymonowi. W języku greckim oznacza skałę, opokę, bo właśnie nią miał być dla Kościoła Piotr – pierwszy papież.	1
Nikodem	375	M	Imię Nikodem jest złożeniem dwóch greckich słów oznaczających zwycięstwo ludu.	2
Mikołaj	3083	M	Mikołaj to imię pochodzenia greckiego. Powstało z dwóch słów „nike” – „zwycięstwo” oraz „laos” – „lud” i znaczy „zwycięstwo ludu”.	3
Marcel	32	M	Marcel to imię pochodzenia łacińskiego. Tak nazywał się jeden z rzymskich rodów – Marcellus. Imię znaczy „mały wojownik”.	4
Leon	32	M	Waleczny jak lew – to powiedzenie pasuje do wielu posiadaczy tego imienia. Leon jest odważny, ale również popędliwy. Ma wielką wolę zwycięstwa. Jest wytrzymały i zdeterminowany. Wiele życiowych wyzwań traktuje jak pojedynek.	5
Kacper	8898	M	Imię pochodzenia perskiego. Powstało z przekształcenia imienia "Kasper", oznaczającego osobę dbającą o swoją cześć lub stróża skarbca.	6
Jan	2259	M	Imię Jan pochodzi z języka hebrajskiego, później przeniknęło również do greki i łaciny. Oznacza tego, któremu jest łaskaw, nad którym zmiłował się Jahwe.	7
Jakub	14497	M	Jakub to imię hebrajskie. Wywodzi się od słowa jaaqob i oznacza ten, którego Bóg ochrania.	8
Igor	121	M	Pierwotnym imieniem skandynawskim, od którego pochodzi imię Igor był Ingwar. Ingwar to połączenie dwóch germańskich słów: Ing – germański bóg ziarna i plonów oraz War – wojownik. Imię Igor na Rusi stało się popularne dzięki Wikingom, którzy  je tam rozpowszechnili.	9
Franciszek	248	M	Imię Franciszek wywodzi się z języka włoskiego i oznacza Francuza, Francuzika. W ten sposób nazwał swojego syna ojciec świętego Franciszka z Asyżu, kiedy ten wrócił do domu z Francji.	10
Julia	8468	Ż	Julia jest to imię pochodzenia rzymskiego, imię to stało się popularne od czasów Juliusza Cezara. Protoplastą rzymskiego rodu Juliuszów miał być Julus, syn legendarnego Eneasza. Jako żeńska forma imienia Juliusz oznacza: promienista, młoda.	11
Zuzanna	8866	Ż	Imię Zuzanna pochodzi od hebrajskiego imienia Szoszannah, które wywodzi się od hebrajskiego słowa shoshano czyli lilia. 	12
Maja	8033	Ż	Maja to imię o nie do końca wyjaśnionym pochodzeniu. Możliwe, że wywodzi się od hebrajskiego słowa mariam (napawać radością) lub egipskiego meri-jam (ukochana przez Boga).	13
Zofia	7928	Ż	Zofia jest to imię pochodzenia greckiego, od słowa sophia (mądrość).	14
Hanna	7723	Ż	mię Hanna funkcjonuje jako odmiana imienia Anna. Pochodzi ono od hebrajskiego słowa Chana czyli „wdzięk, łaska” i oznacza osobę pełną łaski.	15
Lena	7650	Ż	Lena to imię żeńskie, które powstało ze zdrobnienia imion Helena i Magdalena.	16
Maria	5442	Ż	Maria jest to imię pochodzenia hebrajskiego, od słowa mariam (napawać radością) lub od egipskiego meri-jam (ukochana przez Boga). Pierwotna hebrajska wersja imię Miriam przekształcona została na Mariam, stąd Maria.	17
Amelia	5310	Ż	Imię Amelia pochodzi z języka staroniemieckiego i oznacza pracowitą gospodynię lub dzielną obrończynię ogniska domowego.	18
Oliwia	5058	Ż	Oliwia to imię pochodzenia łacińskiego i oznacza gałązkę drzewa oliwnego (która jest symbolem pokoju) albo osobę, która hoduje oliwki.	19
Aleksandra	4428	Ż	Imię Aleksandra pochodzi od jej męskiego odpowiednika Aleksander. Pochodzi ono od greckiego słowa aleksandros (obrońca ludzi).	20
\.


SELECT pg_catalog.setval('public.imiona_id_imie_seq', 20, true);


ALTER TABLE ONLY public.imiona
    ADD CONSTRAINT imiona_pkey PRIMARY KEY (id);