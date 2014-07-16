import std.stdio;
import vibe.d;
import restcloud.configuration.appconfig;

shared static this()
{
	auto settings = new HTTPServerSettings;
	auto appConfig = AppConfigUtil.loadAppConfig();
	settings.port = appConfig.port;
	settings.bindAddresses = ["::1", "127.0.0.1"];
	listenHTTP(settings, &hello);

	logInfo("Please open http://127.0.0.1:8080/ in your browser.");
}

void hello(HTTPServerRequest req, HTTPServerResponse res)
{
	res.writeBody("Hello, World!");
}
