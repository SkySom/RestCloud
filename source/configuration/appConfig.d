module restcloud.configuration.appConfig;

import restcloud.configuration.baseConfig;
import vibe.data.json;
import std.stdio;
import std.file;
import vibe.d;

class AppConfigUtil : BaseConfigUtil {
  void loadAppConfig() {
    logInfo(readText("config/appConfig.json"));
  }
}

struct AppConfig {
  int port;
  string address;
}
