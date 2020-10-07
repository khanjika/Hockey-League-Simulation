create
    definer = root@localhost procedure new_procedure(OUT idDemo int)
BEGIN
    Insert into info (name) values ("emo");
    set idDemo =LAST_INSERT_ID ();
END;

