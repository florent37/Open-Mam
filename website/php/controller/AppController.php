<?php
interface AppController
{

    function start($params);

    function provideApplications();

    function provideApplication($name);
}