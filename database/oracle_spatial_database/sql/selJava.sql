--select the lion
/*
SELECT L.shape
FROM lion L, region R1
WHERE R1.regi_id IN(
		SELECT R2.regi_id
		FROM region R2
		WHERE SDO_CONTAINS(
			R2.shape,
			SDO_GEOMETRY(
				2001,NULL,NULL,
				SDO_ELEM_INFO_ARRAY(1,1,1),
				SDO_ORDINATE_ARRAY(450,300)
			)
		)='TRUE'
	) AND SDO_CONTAINS(
		R1.shape,
		L.shape
	)='TRUE';
*/

--select the pond
/*
SELECT P.shape
FROM pond P, region R1
WHERE R1.regi_id IN(
		SELECT R2.regi_id
		FROM region R2
		WHERE SDO_CONTAINS(
			R2.shape,
			SDO_GEOMETRY(
				2001,NULL,NULL,
				SDO_ELEM_INFO_ARRAY(1,1,1),
				SDO_ORDINATE_ARRAY(100,300)
			)
		)='TRUE'
	) AND SDO_CONTAINS(
		R1.shape,
		P.shape
	)='TRUE';*/
	
	

 