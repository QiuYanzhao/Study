CREATE TABLE course  (
     `cid` bigint(0) NOT NULL,
     `cname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     `user_id` bigint(0) NOT NULL,
     `cstatus` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



CREATE TABLE course_1  (
     `cid` bigint(0) NOT NULL,
     `cname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     `user_id` bigint(0) NOT NULL,
     `cstatus` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


CREATE TABLE course_2  (
     `cid` bigint(0) NOT NULL,
     `cname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     `user_id` bigint(0) NOT NULL,
     `cstatus` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;