create
    definer = root@localhost procedure new_procedure()
BEGIN
			select * from job_activity;
END;

