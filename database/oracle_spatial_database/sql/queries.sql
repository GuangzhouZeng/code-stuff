
--a) Find all lions inside the query window (150, 200) (400, 350). The coordinates indicate (x, y)
--values of the lower left and upper right vertices of query window, respectively.
SELECT L.lion_id
FROM lion L
WHERE SDO_FILTER(L.shape, 
		SDO_GEOMETRY(
			2003,
			NULL,
			NULL,
			SDO_ELEM_INFO_ARRAY(1,1003,3),
			SDO_ORDINATE_ARRAY(150,200,400,350))
		)='TRUE';

/*
SELECT L.lion_id
FROM lion L
WHERE SDO_RELATE(L.shape, 
		SDO_GEOMETRY(
			2003,
			NULL,
			NULL,
			SDO_ELEM_INFO_ARRAY(1,1003,3),
			SDO_ORDINATE_ARRAY(150,200,400,350)),
		'mask=inside')='TRUE'; 
*/

			
--b) Find all the lions which are at most 150 units away from the ponds: P1.
SELECT L.lion_id
FROM lion L, pond P
WHERE P.pond_id='P1' 
	AND	SDO_WITHIN_DISTANCE (
		L.shape,
		P.shape,
		'distance=150')='TRUE';


--d) Find 3 nearest ponds to the lion: L2. Nearest neighbors must be ordered from the closest to
--the furthest one.	
SELECT P.pond_id
FROM pond P, lion L
WHERE L.lion_id='L2' AND
	SDO_NN(P.shape,
			L.shape,
			'SDO_NUM_RES=3')='TRUE';

--should do in this way			
SELECT P.pond_id, SDO_NN_DISTANCE(1) dist
FROM pond P, lion L
WHERE L.lion_id='L2' AND
	SDO_NN(P.shape,
			L.shape,
			'SDO_NUM_RES=3',
			1)='TRUE'
			ORDER BY dist;
	


--f) List all the lions and ponds where lion is inside the pond.(use spatial join)
SELECT L.lion_id, P.pond_id
FROM TABLE(SDO_JOIN('lion','shape',
					'pond','shape',
					'mask=inside')) C,
	lion L,
	pond P
WHERE C.rowid1=L.rowid AND C.rowid2=P.rowid;



--h) List all the region/s which has at-least one lion but no pond.

SELECT UNIQUE R1.regi_id
FROM region R1,
	TABLE (SDO_JOIN(
		'region','shape',
		'lion','shape',
		'mask=contains'
	)) T1
WHERE T1.rowid1=R1.rowid
	AND R1.regi_id NOT IN(
	SELECT R2.regi_id
	FROM TABLE(SDO_JOIN(
		'region','shape',
		'pond','shape',
		'mask=contains'
	 )) T2,
	 region R2
	WHERE  T2.rowid1=R2.rowid
	);
	

	
--i) Find all the lions which are not in the coverage area of any amubulance.

SELECT L.lion_id
FROM lion L
WHERE L.lion_id NOT IN (
		SELECT L2.lion_id
		FROM TABLE (SDO_JOIN(
			'lion','shape',
			'ambulance','shape',
			'mask=inside'
		)) T,
		lion L2
		WHERE T.rowid1=L2.rowid
	);


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
