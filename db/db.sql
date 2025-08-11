create database phone_store;
use phone_store;

create table customer(
	id tinyint unsigned auto_increment primary key,
    Email varchar(50) not null unique key,
    Username varchar(50) not null unique key,
    FullName nvarchar(50) not null,
    address nvarchar(100) not null,
    phone_num int not null unique key,
    CreateDate datetime default now()
);

create table supplieres(
	id tinyint unsigned auto_increment primary key,
    Email varchar(50) not null unique key,
    `name` varchar(50) not null unique key,
    address nvarchar(100) not null,
    phone_num int not null unique key,
    CreateDate datetime default now()
);

create table product(
	id tinyint unsigned auto_increment primary key,
    `name` varchar(50) not null unique key,
    price DECIMAL(10, 2),
    stock_quantity int unsigned,
    capacity enum('GB128', 'GB256', 'GB512', 'TB1'),
    color enum('white', 'black', 'blue', 'yellow')
);

create table supplieres_product(
	suppliers_id tinyint unsigned not null,
    product_id tinyint unsigned not null,
    PRIMARY KEY (suppliers_id, product_id),
    foreign key (suppliers_id) references supplieres(id),
    foreign key (product_id) references product(id)
);
-- drop table supplieres_product
create table `order`(
	id tinyint unsigned auto_increment primary key,
    customer_id tinyint unsigned not null, 
    order_date datetime,
    paying_status enum('pending', 'paid', 'failed', 'refunded'),
    ship_status enum('pending', 'processing', 'shipped', 'delivered', 'cancelled'),
    foreign key (customer_id) references customer(id)
);

create table order_detail(
	id tinyint unsigned auto_increment primary key,
	order_id tinyint unsigned not null,
    product_id tinyint unsigned not null,
    quantity tinyint,
    price DECIMAL(10, 2),
	total_price DECIMAL(10, 2),
    foreign key (order_id) references `order`(id),
    foreign key (product_id) references product(id)
);
 
 DELIMITER $$

CREATE TRIGGER trg_insert_order_detail_values
BEFORE INSERT ON order_detail
FOR EACH ROW
BEGIN
    DECLARE product_price DECIMAL(10, 2);

    -- Lấy giá từ bảng product
    SELECT price INTO product_price 
    FROM product
    WHERE id = NEW.product_id;

    -- Gán vào NEW.price
    SET NEW.price = product_price;

    -- Tính total_price
    SET NEW.total_price = NEW.price * NEW.quantity;
END$$

DELIMITER ;

 -- drop table order_detail
 
INSERT INTO product (name, price, stock_quantity, capacity, color) VALUES
('iPhone 16 Pro Max', 29990000, 10, 'GB256', 'black'),
('iPhone 16', 24990000, 9, 'GB256', 'black'),
('iPhone 15 Pro Max', 27990000, 12, 'GB256', 'white'),
('iPhone 15 Plus', 19990000, 14, 'GB128', 'blue'),
('iPhone 14 Pro', 18990000, 15, 'GB128', 'black'),
('iPhone 14', 15990000, 20, 'GB128', 'yellow'),
('iPhone 13', 14490000, 25, 'GB256', 'blue'),
('iPhone 12 Pro Max', 12990000, 18, 'GB128', 'white');

INSERT INTO customer (Email, Username, FullName, address, phone_num) VALUES 
('john.doe@example.com', 'johndoe', 'John Doe', '123 Main St', 987654321),
('jane.smith@example.com', 'janesmith', 'Jane Smith', '456 Maple Ave', 876543210),
('peter.phan@example.com', 'peterphan', 'Phan Quang', '789 Oak Blvd', 765432109),
('ronaldo7@example.com', 'cr7', 'Cirstiano Ronaldo', '678 OldTrafford Road', 0982262222),
('messi10@example.com', 'm10', 'Lionel Messi', '999 Nguyen Chi Thanh Road', 0372899999);

INSERT INTO supplieres (Email, `name`, address, phone_num) VALUES
('supplier1@example.com', 'Supplier One', '12 Tran Hung Dao, Ha Noi', 910000001),
('supplier2@example.com', 'Supplier Two', '45 Le Loi, Da Nang', 910000002),
('supplier3@example.com', 'Supplier Three', '33 Nguyen Hue, HCM', 910000003);

insert into supplieres_product values
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(3, 6),
(3, 7),
(3, 8);

INSERT INTO `order` (customer_id, order_date, paying_status, ship_status) VALUES
(1, '2025-08-01 09:00:00', 'pending', 'pending'),
(2, '2025-08-01 10:15:00', 'paid', 'processing'),
(3, '2025-08-01 11:30:00', 'paid', 'shipped'),
(4, '2025-08-01 13:45:00', 'paid', 'delivered'),
(5, '2025-08-01 15:00:00', 'refunded', 'cancelled'),
(1, '2025-08-02 08:20:00', 'paid', 'delivered'),
(2, '2025-08-02 09:45:00', 'pending', 'processing'),
(3, '2025-08-02 14:10:00', 'failed', 'pending'),
(4, '2025-08-02 16:25:00', 'paid', 'shipped'),
(5, '2025-08-02 18:40:00', 'paid', 'delivered');

INSERT INTO order_detail (order_id, product_id, quantity) VALUES
(1, 1, 2),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1),
(5, 5, 1),
(6, 1, 1),
(6, 2, 1),
(7, 3, 2),
(8, 4, 1),
(9, 5, 2),
(10, 2, 1),
(10, 1, 1);

use phone_store;
select * from supplieres_product

-- update ORDER_DETAIL
-- SET QUANTITY = 2 WHERE ID = 5;

-- SELECT * FROM ORDER_DETAIL;

-- SHOW TRIGGERS;

-- DROP TABLE ORDER_DETAIL


-- DROP TABLE ORDER_DETAIL

-- SHOW TRIGGERS

-- SELECT * FROM order_detail

-- update order_detail
-- set quantity = 2 
-- where id = 4 

drop database phone_store

















