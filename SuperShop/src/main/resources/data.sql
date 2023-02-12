-- Admin

INSERT INTO `address` (`area`, `building`, `city`, `country`, `pincode`, `society`, `state`) values ('Amroli', 'Pratik Palace', 'Surat', 'India', '394107', 'Raghuvir Society', 'Gujarat');
INSERT INTO `user` (`address_id`, `email`, `first_name`, `last_name`, `password`, `role`) values (1, 'admin@mail', 'Admin', 'Admin', 'admin@123', 'admin');


-- Users

INSERT INTO `address` (`area`, `building`, `city`, `country`, `pincode`, `society`, `state`) values ('Amroli', '75', 'Surat', 'India', '456321', 'Mahaveer Society', 'Gujarat');
INSERT INTO `user` (`address_id`, `email`, `first_name`, `last_name`, `password`, `role`) values (2, 'dipesh@mail', 'Dipesh', 'Singh', 'password', 'user');

INSERT INTO `address` (`area`, `building`, `city`, `country`, `pincode`, `society`, `state`) values ('Amroli', '108', 'Surat', 'India', '456321', 'Hariom Society', 'Gujarat');
INSERT INTO `user` (`address_id`, `email`, `first_name`, `last_name`, `password`, `role`) values (3, 'ashish@mail', 'Ashish', 'Mishra', 'password', 'user');

INSERT INTO `address` (`area`, `building`, `city`, `country`, `pincode`, `society`, `state`) values ('Amroli', '48', 'Surat', 'India', '456321', 'Devikrupa Society', 'Gujarat');
INSERT INTO `user` (`address_id`, `email`, `first_name`, `last_name`, `password`, `role`) values (4, 'rahul@mail', 'Rahul', 'Mewada', 'password', 'user');

INSERT INTO `address` (`area`, `building`, `city`, `country`, `pincode`, `society`, `state`) values ('Amroli', '98', 'Surat', 'India', '456321', 'Suryanagar', 'Gujarat');
INSERT INTO `user` (`address_id`, `email`, `first_name`, `last_name`, `password`, `role`) values (5, 'jay@mail', 'Jay', 'Sanghani', 'password', 'user');

INSERT INTO `address` (`area`, `building`, `city`, `country`, `pincode`, `society`, `state`) values ('Amroli', '75', 'Surat', 'India', '456321', 'Mahaveer Society', 'Gujarat');
INSERT INTO `user` (`address_id`, `email`, `first_name`, `last_name`, `password`, `role`) values (6, 'harshil@mail', 'Harshil', 'Kalsariya', 'password', 'user');


-- Categories

insert into `category` (`name`) values ('Music');

insert into `category` (`name`) values ('Laptop');

insert into `category` (`name`) values ('Smartphone');

insert into `category` (`name`) values ('Fashion');

insert into `category` (`name`) values ('Gadget');


-- Products

insert into `product` (`category_id`, `description`, `image_url`, `name`, `price`, `stock`) values
(
2,
'Lenovo IdeaPad Gaming 3 AMD Ryzen 7 5800H 15.6" (39.62cm) FHD IPS Gaming Laptop (16GB/512GB SSD/6GB NVIDIA RTX 3060/165Hz/Win 11/Office 2021/Backlit/3months Game Pass/Shadow Black/2.25Kg), 82K201UNIN ',
'https://m.media-amazon.com/images/I/71--IQUHVwL._SL1500_.jpg',
'Lenovo IdeaPad Gaming 3',
'89000',
'15'
),
(
2,
'MSI Katana GF76, Intel 11th Gen. i7-11800H, 43CM FHD 144 Hz Gaming Laptop (16GB/512GB NVMe SSD/Windows 11 Home/Nvidia RTX3060 6GB GDDR6/Black/2.6Kg), 11UE-485IN ',
'https://m.media-amazon.com/images/I/81FNbr+8j9L._SL1500_.jpg',
'MSI Katana GF76',
89500,
75
),
(
2,
'ASUS ROG Strix G17 (2022), 17.3"(43.94 cms) WQHD 240Hz/3ms, AMD Ryzen 9 6900HX, 4GB RTX 3070 Ti Graphics, Gaming Laptop (16GB/1TB SSD/90WHrs Battery/Win 11/Office/Volt Green/2.9 kg), G713RW-LL133WS ',
'https://m.media-amazon.com/images/I/71oNV6U1mHL._SL1500_.jpg',
'ASUS ROG Strix G17 (2022)',
189000,
75
),
(
1,
'boAt Rockerz 550 Bluetooth Wireless Over Ear Headphones with Upto 20 Hours Playback, 50MM Drivers, Soft Padded Ear Cushions and Physical Noise Isolation with Mic (Black Symphony) ',
'https://m.media-amazon.com/images/I/61F5SXdi9jL._SL1500_.jpg',
'boAt Rockerz 550 ',
1990,
75
),
(
1,
'boAt Rockerz 450 Iron Man Edition Bluetooth Wireless On Ear Headphones with mic, 15 Hours Battery, 40mm Drivers, Padded Ear Cushions, Easy Access Controls and Voice Assistant(Stark Red)',
'https://m.media-amazon.com/images/I/61ICccqxsuL._SL1500_.jpg',
'boAt Rockerz 450 Iron Man Edition',
1790,
75
),
(
1,
'boAt Immortal 121 TWS Wireless Gaming in Ear Earbuds with Beast Mode(40ms Low Latency), 40H Playtime, Blazing LEDs, Quad Mics ENx Signature Sound, ASAP Charge(10 Mins= 180 Mins)(Black Sabre)',
'https://m.media-amazon.com/images/I/61q-2yzbBtL._SL1500_.jpg',
'boAt Immortal 121 TWS',
1899,
75
),
(
3,
'iQOO Z6 44W by vivo (Lumina Blue, 4GB RAM, 128GB Storage) | 6.44" FHD+ AMOLED Display | 50% Charge in just 27 mins | in-Display Fingerprint Scanning ',
'https://m.media-amazon.com/images/I/61AFUMyh5QL._SL1200_.jpg',
'iQOO Z6',
15990,
75
),
(
3,
'Samsung Galaxy S23 Plus 5G (Cream, 8GB, 256GB Storage) Galaxy Watch4 Bluetooth and ',
'https://m.media-amazon.com/images/I/41VWT06rfnL._SL1001_.jpg',
'Samsung Galaxy S23 Plus 5G ',
98990,
75
),
(
3,
'OnePlus Nord 2T 5G (Gray Shadow, 8GB RAM, 128GB Storage) ',
'https://m.media-amazon.com/images/I/617MPEZB5mL._SL1500_.jpg',
'OnePlus Nord 2T 5G',
28999,
75
);
