DROP TABLE IF EXISTS TBL_STOCK;
 
CREATE TABLE TBL_STOCK (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  price VARCHAR(250) NOT NULL,
  qty VARCHAR(250) NOT NULL
);