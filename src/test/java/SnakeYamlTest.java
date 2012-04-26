import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.Map;

import org.ho.yaml.Yaml;
import org.junit.Test;

import com.adamnengland.YamlConfig;

@SuppressWarnings ("unchecked")
public class SnakeYamlTest {

  @Test
  public void testSimpleConfigurationLoad() throws Exception {
    InputStream input = new FileInputStream(new File("src/test/resources/simpleConfig.yml"));
    Map<String, String> data = (Map<String, String>) Yaml.load(input);
    assertEquals("yaml-shootout", data.get("simple"));
  }
  
  @Test
  public void testAdvancedConfigurationLoad() throws Exception {
    InputStream input = new FileInputStream(new File("src/test/resources/advancedConfig.yml"));
    YamlConfig data = (YamlConfig) Yaml.load(input);
    assertEquals("yaml-shootout", data.simple);
    assertEquals("gmail", data.advanced.type);
  }
}
