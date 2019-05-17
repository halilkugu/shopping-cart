create table Product (
    Id int not null,
    Create_Date datetime not null,
	  Update_Date datetime not null,
    Image_Url varchar(255),
    Name varchar(255) not null,
    Price double precision not null,
    primary key (Id)
);