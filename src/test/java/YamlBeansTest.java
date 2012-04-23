import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.util.Map;

import org.junit.Test;

import com.adamnengland.YamlConfig;
import com.esotericsoftware.yamlbeans.YamlReader;

@SuppressWarnings ("unchecked")
public class YamlBeansTest {

  @Test
  public void testSimpleConfigurationLoad() throws Exception {
    YamlReader reader = new YamlReader(new FileReader("src/test/resources/simpleConfig.yml"));
    Map<String, Object> data = (Map<String, Object>) reader.read();
    assertEquals("yaml-shootout", data.get("simple"));
  }

  @Test
  public void testAdvancedConfigurationLoad() throws Exception {
    YamlReader reader = new YamlReader(new FileReader("src/test/resources/advancedConfig.yml"));
    YamlConfig data = (YamlConfig) reader.read();
    assertEquals("yaml-shootout", data.simple);
    assertEquals("gmail", data.advanced.type);
  }

}
