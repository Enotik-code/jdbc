DELIMITER //

CREATE PROCEDURE `p2` ()
    LANGUAGE SQL
    DETERMINISTIC
    SQL SECURITY DEFINER
    COMMENT 'A procedure'
BEGIN
    SELECT * from developers;
END//

#IN -  входящие( по умолчинаию
DELIMITER //

CREATE PROCEDURE `proc_IN` (IN var1 INT)
BEGIN
    SELECT var1 + 2 AS result;
END//

#OUT - возвращаемый параметр
DELIMITER //

CREATE PROCEDURE `proc_OUT` (OUT var1 VARCHAR(100))
BEGIN
    SET var1 = 'This is a test';
END //


#INOUT - и то, и то
DELIMITER //

CREATE PROCEDURE `proc_INOUT` (INOUT var1 INT)
BEGIN
    SET var1 = var1 * 2;
END //