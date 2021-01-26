import org.aeonbits.owner.Config;

@Config.Sources("classpath:ConfigProperty.properties")
public interface ConfigProperty extends Config {
    @Key("otusUrl")
    String otusUrl();
}