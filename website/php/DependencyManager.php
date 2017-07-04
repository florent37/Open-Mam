<?php
/**
 * Created by PhpStorm.
 * User: florentchampigny
 * Date: 24/06/2017
 * Time: 13:30
 */

function getAppController(){
    $appRepository = new AppRepositoryDb();
    $fileSaver = new FileSaverDirectory();
    $appController = new AppControllerImpl($appRepository, $fileSaver);
    return $appController;
}