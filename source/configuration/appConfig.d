module restcloud.configuration.appConfig;

import restcloud.configuration.baseConfig;
import vibe.data.json;


class AppConfigUtil : BaseConfigUtil {

}

struct AppConfig {
  int port;
  string address;
}
