Drop Table IF exists room CASCADE ;
Drop Table IF exists ventilator CASCADE ;
Drop Table IF exists door CASCADE ;
Drop Table IF exists door_connects_room CASCADE ;
Drop Table IF exists people_in_room CASCADE ;
Drop Table IF exists windows CASCADE ;
Drop Table IF exists doors CASCADE ;
Drop Table IF exists ventilators CASCADE ;
Drop Table IF exists w_indow CASCADE ;


CREATE TABLE "room" (
                        "name" varchar NOT NULL,
                        "size" int NOT NULL,
                        "id" int PRIMARY KEY NOT NULL
);

CREATE TABLE "ventilator" (
                              "id" int PRIMARY KEY ,
                              "room_id" int

);

CREATE TABLE "door" (
    "id" int PRIMARY KEY NOT NULL
);

CREATE TABLE "w_indow" (
                          "id" int PRIMARY KEY NOT NULL,
                          "room_id" int NOT NULL
);

CREATE TABLE "door_connects_room" (
                                      "door_id" int NOT NULL,
                                      "room_id" int NOT NULL,
                                      PRIMARY KEY ("door_id", "room_id")
);

CREATE TABLE "people_in_room" (
                                  "timestamp" timestamp NOT NULL,
                                  "room_id" int NOT NULL,
                                  "nopeopleinroom" int NOT NULL,
                              PRIMARY KEY ("timestamp","room_id", "nopeopleinroom" )
);

CREATE TABLE "windows" (
                           "timestamp" timestamp NOT NULL,
                           "window_id" int NOT NULL,
                           "isopen" boolean NOT NULL,
                           PRIMARY KEY ("timestamp","window_id", "isopen" )
);

CREATE TABLE "doors" (
                         "timestamp" timestamp NOT NULL,
                         "door_id" int NOT NULL,
                         "isopen" boolean NOT NULL,
                         PRIMARY KEY ("timestamp","door_id", "isopen" )
);

CREATE TABLE "ventilators" (
                               "timestamp" timestamp NOT NULL,
                               "ventilator_id" int NOT NULL,
                               ventilator_isOn boolean NOT NULL,
                               PRIMARY KEY ("timestamp","ventilator_id", ventilator_isOn )
);

ALTER TABLE "ventilator" ADD FOREIGN KEY ("room_id") REFERENCES "room" ("id") ON UPDATE CASCADE ON DELETE CASCADE ;

ALTER TABLE "w_indow" ADD FOREIGN KEY ("room_id") REFERENCES "room" ("id") ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE "door_connects_room" ADD FOREIGN KEY ("door_id") REFERENCES "door" ("id") ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE "door_connects_room" ADD FOREIGN KEY ("room_id") REFERENCES "room" ("id") ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE "people_in_room" ADD FOREIGN KEY ("room_id") REFERENCES "room" ("id") ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE "windows" ADD FOREIGN KEY ("window_id") REFERENCES "w_indow" ("id") ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE "doors" ADD FOREIGN KEY ("door_id") REFERENCES "door" ("id") ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE "ventilators" ADD FOREIGN KEY ("ventilator_id") REFERENCES "ventilator" ("id") ON UPDATE CASCADE ON DELETE CASCADE;

Select * From Room;
Select * From ventilator;
Select * From door;
Select * From "w_indow";
Select * From door_connects_room;
Select * From people_in_room;
Select * From windows;
Select * from Doors;
Select * from ventilators
