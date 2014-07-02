import std.stdio;
import vibe.d;
import restcloud.configuration.appConfig;

shared static this()
{
	auto settings = new HTTPServerSettings;
	auto appConfig = new AppConfigUtil;
	appConfig.loadAppConfig();
	settings.port = 8080;
	settings.bindAddresses = ["::1", "127.0.0.1"];
	listenHTTP(settings, &hello);

	logInfo("Please open http://127.0.0.1:8080/ in your browser.");
}

void hello(HTTPServerRequest req, HTTPServerResponse res)
{
	res.writeBody("Hello, World!");
}
