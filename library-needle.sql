drop database if exists library;
create database if not exists library;
use library;

create table book
( 
	isbn varchar(15) unique not null,
    title varchar(40) not null,
    authors varchar(100) not null,
    genre varchar(25),
    total_copies int not null,
    copies_available int not null,
    
    primary key (isbn)
    );
    
create table user
(
	user_id varchar(20) unique not null,
    password varchar(18) not null,
    full_name varchar(50) not null,
    role varchar(50) not null,
    
    primary key (user_id)
    );

create table checkOut
(
	checkout_id int unique not null auto_increment,
	user_id varchar(20) not null,
    isbn varchar(15) not null,
    checkout_date date not null,
    due_date date,
    return_date date,
    
    primary key (checkout_id),
    foreign key (isbn) references book(isbn) on delete cascade on update cascade,
    foreign key (user_id) references user(user_id) on delete cascade on update cascade
    );

    
insert into book values('1-86092-049-7', 'The Grass is Always Greener', 'Jeffrey Archer', 'Modern Times', 15, 15);
insert into book values('1-86092-012-8', 'Murder!', 'Arnold Bennett', 'Crime', 10, 10);
insert into book values('1-86092-031-4', 'The Five Orange Pips', 'Arthur Conan Doyle', 'Crime', 15, 15);
insert into book values('1-86092-014-4', 'The Hostage', 'C. S. Forester', 'Adventure', 15, 15);


insert into user values('yuvsingh',  'pass', 'Yuvran Singh', 'ADMIN');
insert into user values('msdhoni',  'pass', 'MS Dhoni', 'LIBRARIAN');
insert into user values('sachinten',  'pass', 'Sachin Tendulkar', 'USER');
insert into user values('johndoe',  'unknown',  'John Doe', 'USER');
insert into user values('vikramJ',  'pass',  'Vikram M', 'USER');

SELECT book.title as title, user.full_name as fullName, checkout.checkout_date
FROM checkout
INNER JOIN book ON book.isbn = checkout.isbn inner join user on user.user_id = checkout.user_id;


