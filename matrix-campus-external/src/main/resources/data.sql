INSERT INTO brand (brand_id, brand_code, brand_name, brand_description)
VALUES
(1, 'Zara', 'ZARA', 'Zara international shop');

INSERT INTO fee (fee_id, fee_code, fee_name, fee_description)
VALUES
(1, 'ENGLAND_FEE', 'England Fee', 'order´s fee when the origin or destination is placed in England'),
(2, 'SCOTLAND_FEE', 'Scotland fee', 'order´s fee when the origin or destination is placed in Scotland'),
(3, 'JAPAN_FEE', 'Japan Origin fee', 'order´s fee when the origin is placed in Japan'),
(4, 'MEXICO_FEE', 'Mexico Destination fee', 'order´s fee when the destination is placed in Mexico');

INSERT INTO product (product_id, product_code, product_name, product_description)
VALUES
(35455, 'inditex_code', 'Blue Shoes', 'Blue shoes for summer');

INSERT INTO price (brand_id, start_date, end_date, fee_id, product_id, priority, pvp, currency)
VALUES
(1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),
(1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR'),
(1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR'),
(1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');