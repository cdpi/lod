-- https://stackoverflow.com/a/79315986

CREATE VIEW `uuid7` AS

WITH `unixtime` AS
	(
	SELECT CAST((UNIXEPOCH('subsec') * 1000) AS INTEGER) AS `time`
	)

SELECT
	PRINTF('%08x-%04x-%04x-%04x-%012x',
	(SELECT `time` FROM `unixtime`) >> 16,
	(SELECT `time` FROM `unixtime`) & 0xFFFF,
	ABS(RANDOM()) % 0x0FFF + 0x7000,
	ABS(RANDOM()) % 0x3FFF + 0x8000,
	ABS(RANDOM()) >> 16)
	AS `next`;
