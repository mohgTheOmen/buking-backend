CREATE TABLE property
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    address     VARCHAR(255),
    description TEXT,
    star_rating INTEGER,
    image_url   VARCHAR(1000)
);

INSERT INTO property (name, address, description, star_rating, image_url)
VALUES ('Hilton Downtown', '123 Main Street, New York', 'Luxury hotel in the heart of Manhattan', 5,
        'https://images.unsplash.com/photo-1542314831-068cd1dbfeeb'),
       ('Seaside Resort', '456 Beach Road, Miami', 'Beautiful beachfront property with ocean views', 4,
        'https://images.unsplash.com/photo-1571896349842-33c89424de2d'),
       ('Mountain Lodge', '789 Pine Avenue, Denver', 'Cozy mountain retreat with spectacular views', 4,
        'https://images.unsplash.com/photo-1520250497591-112f2f40a3f4');

CREATE TABLE room
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_number     VARCHAR(50),
    room_type       VARCHAR(50),
    price_per_night DECIMAL(10, 2),
    capacity        INTEGER,
    image_url       VARCHAR(1000),
    property_id     BIGINT,
    FOREIGN KEY (property_id) REFERENCES property (id)
);

INSERT INTO room (room_number, room_type, price_per_night, capacity, property_id, image_url)
VALUES ('101', 'STANDARD', 199.99, 2, 1, 'https://images.unsplash.com/photo-1631049307264-da0ec9d70304'),
       ('102', 'DELUXE', 299.99, 2, 1, 'https://images.unsplash.com/photo-1618773928121-c32242e63f39'),
       ('201', 'SUITE', 499.99, 4, 1, 'https://images.unsplash.com/photo-1590490360182-c33d57733427'),

       ('A101', 'OCEAN VIEW', 259.99, 2, 2, 'https://images.unsplash.com/photo-1582719508461-905c673771fd'),
       ('A102', 'BEACH FRONT', 359.99, 3, 2, 'https://images.unsplash.com/photo-1566665797739-1674de7a421a'),
       ('B201', 'FAMILY SUITE', 459.99, 5, 2, 'https://images.unsplash.com/photo-1616594039964-ae9021a400a0'),

       ('L1', 'CABIN', 199.99, 2, 3, 'https://images.unsplash.com/photo-1602002418082-a4443e081dd1'),
       ('L2', 'LUXURY CABIN', 299.99, 4, 3, 'https://images.unsplash.com/photo-1598928506311-c55ded91a20c'),
       ('L3', 'MOUNTAIN SUITE', 399.99, 6, 3, 'https://images.unsplash.com/photo-1578683010236-d716f9a3f461');