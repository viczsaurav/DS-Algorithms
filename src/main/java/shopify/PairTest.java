package shopify;

import java.util.*;

public class PairTest {

    public static void main(String[] args) {

//        //Hardcode the values = K, Value -
//        Node n1 = new Node("val1");
//        Node n2 = new Node("val2");
//        Node n3 = new Node("val3");
//        Node n4 = new Node("val4");

        Map<String, String> cache = new Cache<>(3);

        // Read from console

        // Write
        cache.put("key1", "val1");
        System.out.println("After key1 -" + cache.toString());
        cache.put("key2", "val2");
        cache.put("key3", "val3");
        System.out.println("After key3 -" + cache.toString());
        cache.put("key4", "val4");
        System.out.println("After key4 -" + cache.toString());
        System.out.println("Read Key 1 - " + cache.get("key1"));
        System.out.println("Read Key 2 - " + cache.get("key2"));
        System.out.println("After read -key2 -" + cache.toString());
        cache.put("key5", "val5");
        cache.put("key6", "val6");
        System.out.println("After adding Key5/Key6 -" + cache.toString());
        System.out.println("Count -" + cache.size());
        cache.put("key5", "val5-overwrite");
        System.out.println("Read Key 5 - " + cache.get("key5"));
        cache.remove("key5");
        System.out.println("Remove Key 5 - " + cache.toString());
        cache.clear();
        System.out.println("After clear: " + cache.toString());

    }
}

class Cache<K, V> extends LinkedHashMap<K, V> {

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    int MAX_SIZE;
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > MAX_SIZE;
    }

    public Cache (int max_size) {
        super(max_size, DEFAULT_LOAD_FACTOR, true);
        this.MAX_SIZE = max_size;
    }
}

/**
 * 
# LRU Cache

An in memory cache implementation that expires the least recently used items, and limits cache size by a maximum number of items.

## API

A cache object can be instantiated in memory. It requires the max number of records as an argument:
```ruby
cache = Cache.new(max_size: 100)
```

An object may be written to a string cache key:
```ruby
cache.write("key", value)
```

That object may be retrieved by a key, or `nil` is returned if it is not found:
```ruby
cache.read("key")
```

A cached value may be deleted by key:
```ruby
cache.delete("key")
```

All values may be deleted:
```ruby
cache.clear
```

The number of records can be fetched at any time:
```ruby
cache.count
```


## Example

```ruby
> cache = Cache.new(max_size: 3)
=> #<Cache>

> cache.to_h
=> {}

> cache.write("key1", "val1")
=> "val1"

> cache.to_h
=> {"key1"=>"val1"}

> cache.write("key2", "val2")
=> "val2"

> cache.to_h
=> {"key1"=>"val1", "key2"=>"val2"}

> cache.write("key3", "val3")
=> "val3"

> cache.to_h
=> {"key1"=>"val1", "key2"=>"val2", "key3"=>"val3"}

> cache.write("key4", "val4")
=> "val4"

> cache.to_h
=> {"key2"=>"val2", "key3"=>"val3", "key4"=>"val4"}

> cache.read("key1")
=> nil

> cache.read("key2")
=> "val2"

> cache.to_h
=> {"key2"=>"val2", "key3"=>"val3", "key4"=>"val4"}

> cache.write("key5", "val5")
=> "val5"

> cache.write("key6", "val6")
=> "val6"

> cache.to_h
=> {"key2"=>"val2", "key5"=>"val5", "key6"=>"val6"}

> cache.count
=> 3

> cache.write("key5", "value5-overwrite")
=> "value5-overwrite"

> cache.read("key5")
=> "value5-overwrite"

> cache.delete("key5")
=> "value5-overwrite"

> cache.clear
=> 2

> cache.to_h
=> {}
```
 */
