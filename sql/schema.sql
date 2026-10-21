

CREATE TABLE `inktober`
	(
	`uuid` TEXT PRIMARY KEY,
	`year` INTEGER NOT NULL,
	`en` TEXT NOT NULL,
	`fr` TEXT NOT NULL,
	CONSTRAINT `check_inktober_uuid` CHECK (uuid REGEXP '[a-f0-9]{8}-([a-f0-9]{4}-){3}[a-f0-9]{12}')
	);

CREATE TRIGGER `trigger_after_insert_on_inktober`
	AFTER INSERT
	ON `inktober`
	FOR EACH ROW
	WHEN NEW.uuid IS NULL
BEGIN
	UPDATE `inktober`
	SET `uuid` =
		(
		SELECT `next`
		FROM `uuid7`
		)
	WHERE ROWID = NEW.ROWID;
END;


