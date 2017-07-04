<?php

//Retourne une connection à la base de données
function getConnection()
{
    static $database = null;

    if ($database == null) {
        $dbhost = "database"; //identique à l'alias docker
        $dbname = "APPLICATION";
        $dbuser = "root";
        $dbpassword = "password";

        $database = new PDO("mysql:host=$dbhost;port=3306;dbname=" . $dbname, $dbuser, $dbpassword, array(
            PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
            PDO::ATTR_PERSISTENT => true
        )); // connexion à la BDD
    }

    return $database;
}

function createDatabase()
{
    $dbhost = "database"; //identique à l'alias docker
    $dbuser = "root";
    $dbpassword = "password";

    try {
        $dbh = new PDO("mysql:host=$dbhost;port=3306", $dbuser, $dbpassword);
        $dbh->exec(getSqlFile("database/APPLICATION.sql"));
    } catch (PDOException $e) {
        die("DB ERROR: " . $e->getMessage());
    }
}

function getSqlFile($fileName)
{
    return file_get_contents(ROOT_DIR . $fileName);
}

?>