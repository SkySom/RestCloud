import std.stdio;

import vibe.d;
//import ddbc.drivers.pgsqlddbc;

import restcloud.configuration.appconfig;

shared static this()
{
	auto settings = new HTTPServerSettings;
	auto appConfig = AppConfigUtil.loadAppConfig();
	settings.port = appConfig.port;
	settings.bindAddresses = ["::1", "127.0.0.1"];
	listenHTTP(settings, &hello);
	//PGSQLDriver driver = new PGSQLDriver();
	logInfo("Please open http://%s:%d/in your broswer.",appConfig.address,
	 appConfig.port);
}

void hello(HTTPServerRequest req, HTTPServerResponse res)
{
	res.writeBody("Hello, World!");
}
