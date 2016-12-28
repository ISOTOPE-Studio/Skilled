<?php

$plugin = $_REQUEST['plugin'];
$version = $_REQUEST['version'];
if($plugin=="Skilled"){
    define("Latest", "1.1.4a");
    if($version==Latest)
        echo "no";
    else
        echo "yes";
}
if($plugin=="WTP"){
    define("Latest", "2.0.0");
    if($version==Latest)
        echo "no";
    else
        echo "yes";
}
?>