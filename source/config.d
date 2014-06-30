import std.stdio;
import yaml;

class Config {
	
	Node config;

	void loadConfig(string location) {
		if(location == "") {
			location = "config.yaml";
		}

		config = Loader(location).load();
	}
	
	string getSetting(string name) {
		return config[name.toString()].as!ushort;	
	}
}