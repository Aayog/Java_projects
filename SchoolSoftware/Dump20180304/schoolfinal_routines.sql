-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: schoolfinal
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping routines for database 'schoolfinal'
--
/*!50003 DROP PROCEDURE IF EXISTS `EXAM_ROUTINE_CURD` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `EXAM_ROUTINE_CURD`(

IN _MODE VARCHAR(1),
IN _EXAM_TYPE VARCHAR(45),
IN _CLASH INT,
IN _SUBJECT VARCHAR(45),
IN _ROLL VARCHAR(45),
IN _THEORY_MARKS INT,
IN _PRACTICLE_MARKS INT
)
BEGIN

	IF _MODE='I' THEN
    
    INSERT INTO `schoolfinal`.`exam_routine`(EXAM_TYPE, CLASS, SUBJECT, ROLL, THEORY_MARKS, PRACTICLE_MARKS) VALUES(_EXAM_TYPE,_CLASH,_SUBJECT,_ROLL,_THEORY_MARKS,_PRACTICLE_MARKS);
    
    END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `STUDENT_INFO_CRUD` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `STUDENT_INFO_CRUD`(
IN _MODE CHAR,
IN _FULL_NAME VARCHAR(45),
IN _CLASS VARCHAR(45),
IN _ROLL INT,
IN _ADDRESS VARCHAR(45),
IN _PHONE_NO VARCHAR(10)
)
BEGIN

	DECLARE _SNIN INT DEFAULT(-1);
	
	IF _MODE= 'I' THEN
    
		INSERT INTO `student_info`(`FULL_NAME`,`CLASS`,`ROLL`,`ADDRESS`,`PHONE_NO`) 
        VALUES(_FULL_NAME,_CLASS,_ROLL,_ADDRESS,_PHONE_NO);
        
	/* ELSEIF _MODE='U' THEN
    
		/* SELECT `SN` INTO _SNIN FROM `student_info` WHERE `ID`=_ID;			  /* necessary ID FOR UPDATE PROCESS */
        
		/* UPDATE `student_info` SET `ID`=_ID,`FULL_NAME`=_FULL_NAME , 
				`CLASS`=_CLASS,`ROLL`=_ROLL ,`FATHER_NAME`=_FATHER_NAME , 
                `ADDRESS`=_ADDRESS , `PHONE_NO`=_PHONE_NO WHERE `SN`=_SNIN; */
                
	
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `STUDENT_INFO_CRUD_FINAL` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `STUDENT_INFO_CRUD_FINAL`(
IN _MODE CHAR,
INOUT _ID INT,
IN _FIRST_NAME VARCHAR(45), -- CUMPULSARY
IN _MIDDLE_NAME VARCHAR(45),
IN _LAST_NAME VARCHAR(45),  -- CUMPULSARY
IN _PICTURE mediumblob,			
IN _PHONE VARCHAR(45),		-- CUMPULSARY
IN _ADDRESS VARCHAR(45),	-- CUMPULSARY
IN _EMAIL VARCHAR(45),	
IN _CLASS INT,				-- CUMPULSARY
IN _ROLL INT,				-- CUMPULSARY
IN _CREATED_BY VARCHAR(45),	-- CUMPULSARY
IN _ADMINITON_DATE VARCHAR(45),	
IN _CREATED_DATE VARCHAR(45),		-- CUMPULSARY
IN _UPDATED_BY VARCHAR(45),
IN _UPUDATED_DATE VARCHAR(45),
IN _PARENT VARCHAR(45)
)
BEGIN
IF _FIRST_NAME='' THEN 
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = ' FIRST NAME CAN NOT BE EMPTY !!!';
ELSEIF _LAST_NAME='' THEN 
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = ' LAST NAME CAN NOT BE EMPTY !!!';
ELSEIF _PHONE='' THEN 
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = ' PHONE NUMBER CAN NOT BE EMPTY !!!';
ELSEIF _CLASS='' THEN 
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = ' CLASS CAN NOT BE EMPTY !!!';
ELSEIF _ROLL=-1 THEN 
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = ' ROLL NUMBER CAN NOT BE EMPTY !!!';
ELSEIF _CREATED_BY='' THEN 
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = ' USER MUST LOGIN TO INSERT DATA!!!';
ELSEIF _CREATED_BY=-1 THEN 
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = ' FIRST NAME CAN NOT BE EMPTY !!!';
END IF;

IF _MODE='I' THEN

	INSERT INTO STUDENT_INFO(FIRST_NAME, MIDDLE_NAME, LAST_NAME, PICTURE, PHONE, ADDRESS, EMAIL, CLASS, ROLL,
								CREATED_BY, ADMINITON_DATE, CREATED_DATE,UPDATED_BY,UPDATED_DATE,`FATHER/MOTHER`)
    VALUES(_FIRST_NAME, _MIDDLE_NAME, _LAST_NAME, _PICTURE, _PHONE, _ADDRESS, _EMAIL, _CLASS, _ROLL
    , _CREATED_BY, SYSDATE(), SYSDATE(),"",NULL,_PARENT);
    
    SELECT ID INTO _ID FROM STUDENT_INFO WHERE 	FIRST_NAME=_FIRST_NAME AND
												MIDDLE_NAME=_MIDDLE_NAME AND 
												LAST_NAME=_LAST_NAME AND
												EMAIL=_EMAIL AND 
												CLASS=_CLASS AND
												ROLL=_ROLL;
												
    
ELSEIF _MODE='U' THEN
	
    IF _UPDATED_BY='' THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = ' USER MUST BE LOGED IN !!!';
	ELSE
		UPDATE STUDENT_INFO SET FIRST_NAME=_FIRST_NAME ,
								MIDDLE_NAME=_MIDDLE_NAME, 
								LAST_NAME=_LAST_NAME,
								PICTURE=_PICTURE ,
								PHONE=_PHONE ,
								ADDRESS=_ADDRESS ,
								EMAIL=_EMAIL ,
								CLASS=_CLASS ,
								ROLL=_ROLL ,
								CREATED_BY=_CREATED_BY ,
								ADMINITON_DATE=SYSDATE() ,
								CREATED_DATE=SYSDATE(),
                                UPDATED_BY=_UPDATED_BY ,
                                UPDATED_DATE=SYSDATE()
                                
		WHERE ID=_ID;
    END IF;
    
ELSEIF _MODE='D' THEN
	DELETE FROM STUDENT_INFO WHERE ID=_ID;
END IF;
-- ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME,
-- PICTURE, PHONE, ADDRESS, EMAIL, CLASS, ROLL, CREATED_BY, ADMINITON_DATE

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `STUDENT_INFO_VIEW_FINAL` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `STUDENT_INFO_VIEW_FINAL`()
BEGIN

	SELECT * FROM STUDENT_INFO WHERE 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `STUDENT_RECORD_VIEW_SEARCH` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `STUDENT_RECORD_VIEW_SEARCH`(
IN _FIRST_NAME VARCHAR(45),
IN _CLASS VARCHAR(10),
IN _ROLL INT,	-- IF ROLL IS NOT NULL THEN CLASS CAN NOT BE NULL
IN _PHONE VARCHAR(45),
IN _DATE_FROM VARCHAR(45),
IN _DATE_TO VARCHAR(45)
)
BEGIN
	DECLARE DYNAMIC_QUERY VARCHAR(80) DEFAULT '';
    DECLARE _ROLL_CLASS_INDEX VARCHAR(10) DEFAULT 'Y';
    DECLARE VAR VARCHAR(45) DEFAULT '';
    SET @DYNAMIC_QUERY="SELECT * FROM STUDENT_INFO WHERE ";
	SET @VAR="CLASS='";
    


	IF _FIRST_NAME<>'' THEN
			SET @DYNAMIC_QUERY=concat(@DYNAMIC_QUERY,"FIRST_NAME='",_FIRST_NAME,"'");
            SET @VAL="AND CLASS='";
	END IF;
    
    IF _CLASS<>'' THEN
			SET @_ROLL_CLASS_INDEX='N';
			SET @DYNAMIC_QUERY=concat(@DYNAMIC_QUERY,@VAL,_CLASS,"'");
            SET @VAL="AND ROLL='";
    ELSE SET @VAL="ROLL='";
    END IF;
    
    IF _ROLL<>-1 THEN
			IF _CLASS='' THEN SIGNAL SQLSTATE '45000' 
							SET MESSAGE_TEXT = ' CLASS CAN NOT BE NULL IF ROLL IS NOT NULL !!!';
			ELSE
					SET @DYNAMIC_QUERY=concat(@DYNAMIC_QUERY,@VAL,_ROLL,"'");
					SET @VAL="AND PHONE='";
			END IF;
            
	ELSE SET @VAL="PHONE='";
	END IF;
    
    IF _PHONE<>'' THEN
			SET @DYNAMIC_QUERY=concat(@DYNAMIC_QUERY,@VAL,_PHONE,"'");
			SET @VAL="AND ADMINITON_DATE='";
	ELSE SET @VAL="ADMINITON_DATE='";
	END IF;
    
    IF _DATE_FROM<>'' AND _DATE_TO='' THEN
			SET @DYNAMIC_QUERY=concat(@DYNAMIC_QUERY,@VAL,_DATE_FROM,"'");
            
    ELSEIF	_DATE_FROM<>'' AND _DATE_TO<>'' THEN
			SET @DYNAMIC_QUERY=concat(@DYNAMIC_QUERY,@VAL,"BETWEEN '",_DATE_FROM,"' AND'",_DATE_TO,"'");
	END IF;
	
    PREPARE FINAL_QUERY FROM @DYNAMIC_QUERY;
    EXECUTE FINAL_QUERY;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `STUDENT_RECORD_VIEW_SEARCH_FINAL` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `STUDENT_RECORD_VIEW_SEARCH_FINAL`(
IN _FIRST_NAME VARCHAR(45),
IN _CLASS VARCHAR(10),
IN _ROLL INT,	-- IF ROLL IS NOT NULL THEN CLASS CAN NOT BE NULL
IN _PHONE VARCHAR(45),
IN _DATE_FROM VARCHAR(45),
IN _DATE_TO VARCHAR(45)
)
BEGIN
	DECLARE DYNAMIC_QUERY VARCHAR(80) DEFAULT '';
    DECLARE _ROLL_CLASS_INDEX VARCHAR(10) DEFAULT 'Y';
    DECLARE VAR VARCHAR(45) DEFAULT '';
    SET @DYNAMIC_QUERY="SELECT * FROM STUDENT_INFO WHERE ";
	SET @VAR="CLASS='";

	IF _FIRST_NAME<>'' THEN
			SET @DYNAMIC_QUERY=concat(@DYNAMIC_QUERY,"FIRST_NAME='",_FIRST_NAME,"'");
            SET @VAL="AND CLASS='";
	END IF;
    
    IF _CLASS<>'' THEN
			SET @_ROLL_CLASS_INDEX='N';
			SET @DYNAMIC_QUERY=concat(@DYNAMIC_QUERY,@VAL,_CLASS,"'");
            SET @VAL="AND ROLL='";
    ELSE SET @VAL="ROLL='";
    END IF;
    
    IF _ROLL<>-1 THEN
			IF _CLASS='' THEN SIGNAL SQLSTATE '45000' 
							SET MESSAGE_TEXT = ' CLASS CAN NOT BE NULL IF ROLL IS NOT NULL !!!';
			ELSE
					SET @DYNAMIC_QUERY=concat(@DYNAMIC_QUERY,@VAL,_ROLL,"'");
					SET @VAL="AND PHONE='";
			END IF;
            
	ELSE SET @VAL="PHONE='";
	END IF;
    
    IF _PHONE<>'' THEN
			SET @DYNAMIC_QUERY=concat(@DYNAMIC_QUERY,@VAL,_PHONE,"'");
			SET @VAL="AND ADMINITON_DATE='";
	ELSE SET @VAL="ADMINITON_DATE='";
	END IF;
    
    IF _DATE_FROM<>'' AND _DATE_TO='' THEN
			SET @DYNAMIC_QUERY=concat(@DYNAMIC_QUERY,@VAL,_DATE_FROM,"'");
            
    ELSEIF	_DATE_FROM<>'' AND _DATE_TO<>'' THEN
			SET @DYNAMIC_QUERY=concat(@DYNAMIC_QUERY,@VAL,"BETWEEN '",_DATE_FROM,"' AND'",_DATE_TO,"'");
	END IF;
	
    PREPARE FINAL_QUERY FROM @DYNAMIC_QUERY;
    EXECUTE FINAL_QUERY;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SUBJECT_INFO_CRUD` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SUBJECT_INFO_CRUD`(
IN _MODE VARCHAR(2),
IN _SUBJECTS_NAME VARCHAR(45),
IN _CLASS VARCHAR(10)
)
BEGIN
	DECLARE _DBSN INT DEFAULT (-1);

	IF _MODE='I' THEN
		
        INSERT INTO `subjects_info`(SUBJECTS_NAME, CLASS) 
				VALUES(_SUBJECTS_NAME,_CLASS);
              
	END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `TEST` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TEST`(
IN _MODE CHAR,
IN _ID VARCHAR(45),
IN _FULL_NAME VARCHAR(45),
IN _CLASS INT,
IN _ROLL INT,
IN _FATHER_NAME VARCHAR(45),
IN _ADDRESS VARCHAR(45),
IN _PHONE_NO VARCHAR(10)

)
BEGIN
DECLARE _DBSN INT DEFAULT(-1);
		SELECT `SN` INTO _DBSN FROM `student_info` WHERE `ID`=_ID;
        SELECT * FROM  `student_info` WHERE `SN`=_DBSN;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `test_to_dynamic_query` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `test_to_dynamic_query`(
in _id int,
in _lFIRST_NAME varchar(45),
IN _PHONE varchar(45),
IN _ROLL INT
)
BEGIN
	-- declare val varchar(45)default null ;
    -- declare lastQ varchar(45);
	declare stm varchar(45) default '';
    set @stm="select * from student_info where ";
	set @val="FIRST_NAME='";
    -- set @lastQ:='ROLL';
    
    if _id<>-1 then
			set @stm=group_concat(@stm,'ID=',_id);
            set @val="OR FIRST_NAME='";
	end if;
    
	if _lFIRST_NAME<>'' then
			set @stm=concat(@stm,@val,_lFIRST_NAME,"'");
            set @val='OR ROLL=';
	else 
		set @val='ROLL=';
	end if;
            
	if _ROLL<>-1 then
			set @stm=concat(@stm,@val,_ROLL);
    end if;
    
    PREPARE stmt1 FROM @stm;
	EXECUTE stmt1;
    DEALLOCATE PREPARE stmt1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-04  7:54:48
