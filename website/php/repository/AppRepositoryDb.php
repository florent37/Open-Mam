<?php

/**
 * Created by PhpStorm.
 * User: florentchampigny
 * Date: 18/06/2017
 * Time: 14:02
 */
class AppRepositoryDb implements AppRepository {
    public function provideApplications()
    {
        $db = getConnection();
        $requete=$db->prepare( "SELECT a.*, max(v.CODE) as lastCode, v.version as lastVersion FROM APPLICATION a, VERSION v WHERE a.APP_ID = v.APP_ID"); //verify user access, for now give him all apps
        $requete->execute();

        $apps = [];

        while($row = $requete->fetch( PDO::FETCH_NAMED )){
            $app = new App();

            $app->name = $row["APP_NAME"];
            $app->packageName = $row["APP_PACKAGE"];
            $app->dateLastUpdate = $row["dateLastUpdate"];
            $app->image = $row["APP_IMAGE"];
            $app->lastCode = $row["lastCode"];
            $app->lastVersion = $row["lastVersion"];

            $apps[] = $app;
        }
        $db = null;

        return $apps;
    }

    public function provideApplication($name)
    {
        $db = getConnection();

        $requete=$db->prepare("SELECT * from APPLICATION a , VERSION v WHERE a.APP_NAME=? AND a.APP_ID = v.APP_ID"); //verify user access, for now give him all apps
        $requete->execute(
            array($name)
        );

        //TODO limit

        $versions = [];

        while($row = $requete->fetch( PDO::FETCH_NAMED )){
            $version = new AppVersion();

            $version->code = $row["CODE"];
            $version->comment = $row["COMMENT"];
            $version->date = $row["date"];
            $version->url = $row["URL"];
            $version->version = $row["VERSION"];

            $versions[] = $version;
        }
        $db = null;

        return $versions;
    }

    public function addAppVersion($appName, $package, $appVersion, $appCode, $comment, $fileUrl)
    {
        $db = getConnection();

        $sql = "INSERT INTO APPLICATION (APP_NAME, APP_PACKAGE) VALUES (?, ?)";

        $requete = $db->prepare($sql);
        $requete->execute(array($appName, $package));
        $app_id = $db->lastInsertId();

        if($app_id == 0){
            $sql = "SELECT APP_ID FROM APPLICATION WHERE APP_NAME = ?";
            $requete = $db->prepare($sql);
            $requete->execute(array($appName));
            $app_id = $requete->fetch()["APP_ID"];
        }

        $sql = "INSERT INTO VERSION (VERSION, CODE, URL, APP_ID, DATE) VALUES (?, ?, ?, ?, NOW())";

        $requete = $db->prepare($sql);
        $requete->execute(array($appVersion, $appCode, $fileUrl, $app_id));

        $db = null;
    }
}