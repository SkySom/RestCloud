module restcloud.configuration.appConfig;

import restcloud.configuration.baseConfig;
import vibe.data.json;
import std.file;
import vibe.d;

class AppConfigUtil : BaseConfigUtil {
  static AppConfig loadAppConfig() {
    auto jsonString = readText("config/appConfig.json");
    AppConfig config = deserializeJson!AppConfig(jsonString);
    return config;
  }

  void createAppConfig() {
    AppConfig appConfig;
    appConfig.port = 8080;
    appConfig.address = "127.0.0.1";

    auto json = serializeToJson(appConfig);
    write("config.json", json.toString());
  }
}

struct AppConfig {
  int port;
  string address;
}
