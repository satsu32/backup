set names utf8;
set foreign_key_checks=0;
drop database if exists joker;

create database if not exists joker;
use joker;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
updated_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(30),
item_image varchar(255),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary  key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);

INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("Pen","./images/item/pen.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("PC","./images/item/pc.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("NoteBook","./images/item/notebook.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("テレビ","./images/item/tv.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("ゲーム","./images/item/game.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("カメラ","./images/item/camera.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("ビデオカメラ","./images/item/videocamera.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("ドローン","./images/item/drone.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("オーディオ","./images/item/audio.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("電子ピアノ","./images/item/piano.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("カー用品","./images/item/cargoods.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("ビューディー","./images/item/beauty.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("健康家電","./images/item/health.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("時計","./images/item/watch.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("スーツケース","./images/item/case.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("医薬品","./images/item/medicine.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("インク","./images/item/inc.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("メディア","./images/item/media.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("電池","./images/item/battery.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("映画","./images/item/cinema.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("音楽","./images/item/music.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("おもちゃ","./images/item/hobby.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("電子辞書","./images/item/dictionary.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("スマートフォン","./images/item/smartphone.jpg",200,80);
INSERT INTO item_info_transaction(item_name,item_image, item_price,item_stock) VALUES("格安ＳＩＭ","./images/item/sim.jpg",200,80);


INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("ooo","555","555");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("taro","123","test");