package map;

/**
 *
 * @author max
 */
public class MapGen {

    protected int seed;
    protected Noise noiseGenerator;

    public MapGen(int seed) {
        this.seed = seed;
        this.noiseGenerator = new Noise(this.seed, 16, 1.27f);
    }

    public enum TYPE {

        UNDEFINED, WATER, LAND, HIDDEN
    };

    public Enum getType(int x, int y) {
        float noise = noiseGenerator.perlinNoise2D((float) (x) / 300000 , (float) (y) / 300000);

        if (false) {
            return Enum.valueOf(TYPE.class, "UNDEFINED");
        } else if (false) {
            return Enum.valueOf(TYPE.class, "HIDDEN");
        } else if (noise < 20) {
            return Enum.valueOf(TYPE.class, "WATER");
        } else {
            return Enum.valueOf(TYPE.class, "LAND");
        }
    }

    /**
     * Get the value of seed
     *
     * @return the value of seed
     */
    public int getSeed() {
        return seed;
    }

    /**
     * Set the value of seed
     *
     * @param seed new value of seed
     */
    public void setSeed(int seed) {
        this.seed = seed;
    }
}
