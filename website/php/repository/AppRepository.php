<?php

/**
 * Created by PhpStorm.
 * User: florentchampigny
 * Date: 18/06/2017
 * Time: 14:02
 */
interface AppRepository
{
    public function provideApplications();

    public function provideApplication($name);

    public function addAppVersion($appName, $package, $appVersion, $appCode, $comment, $fileUrl);
}