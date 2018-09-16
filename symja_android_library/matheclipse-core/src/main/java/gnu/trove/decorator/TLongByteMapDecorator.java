///////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2002, Eric D. Friedman All Rights Reserved.
// Copyright (c) 2009, Robert D. Eden All Rights Reserved.
// Copyright (c) 2009, Jeff Randall All Rights Reserved.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
///////////////////////////////////////////////////////////////////////////////

package gnu.trove.decorator;

import gnu.trove.map.TLongByteMap;
import gnu.trove.iterator.TLongByteIterator;

import java.io.*;
import java.util.*;


//////////////////////////////////////////////////
// THIS IS A GENERATED CLASS. DO NOT HAND EDIT! //
//////////////////////////////////////////////////


/**
 * Wrapper class to make a TLongByteMap conform to the <tt>java.util.Map</tt> API.
 * This class simply decorates an underlying TLongByteMap and translates the Object-based
 * APIs into their Trove primitive analogs.
 * <p/>
 * Note that wrapping and unwrapping primitive values is extremely inefficient.  If
 * possible, users of this class should override the appropriate methods in this class
 * and use a table of canonical values.
 * <p/>
 * Created: Mon Sep 23 22:07:40 PDT 2002
 *
 * @author Eric D. Friedman
 * @author Robert D. Eden
 * @author Jeff Randall
 */
public class TLongByteMapDecorator extends AbstractMap<Long, Byte>
	implements Map<Long, Byte>, Externalizable, Cloneable {

	static final long serialVersionUID = 1L;

    /** the wrapped primitive map */
    protected TLongByteMap _map;


    /**
     * FOR EXTERNALIZATION ONLY!!
     */
    public TLongByteMapDecorator() {}


    /**
     * Creates a wrapper that decorates the specified primitive map.
     *
     * @param map the <tt>TLongByteMap</tt> to wrap.
     */
    public TLongByteMapDecorator( TLongByteMap map ) {
        super();
        this._map = map;
    }


    /**
     * Returns a reference to the map wrapped by this decorator.
     *
     * @return the wrapped <tt>TLongByteMap</tt> instance.
     */
    public TLongByteMap getMap() {
        return _map;
    }


    /**
     * Inserts a key/value pair into the map.
     *
     * @param key   an <code>Object</code> value
     * @param value an <code>Object</code> value
     * @return the previous value associated with <tt>key</tt>,
     *         or Byte(0) if none was found.
     */
    @Override
    public Byte put( Long key, Byte value ) {
        long k = unwrapKey( key );
        byte v = unwrapValue( value );
        if ( _map.containsKey( k ) ) {
            byte retval = _map.put( k, v );
            return wrapValue( retval);
        }
        _map.put( k, v );
        return null;
    }


    /**
     * Retrieves the value for <tt>key</tt>
     *
     * @param key an <code>Object</code> value
     * @return the value of <tt>key</tt> or null if no such mapping exists.
     */
    @Override
    public Byte get( Object key ) {
        if (! ( key instanceof Long ) ) {
            return null;
        }
        long k = unwrapKey( key );
        byte v = _map.get( k );
        if (v == _map.getNoEntryValue() && !_map.containsKey( k ) ) {
            return null;
        }
        return wrapValue( v );
    }


    /**
     * Empties the map.
     */
    @Override
    public void clear() {
        this._map.clear();
    }


    /**
     * Deletes a key/value pair from the map.
     *
     * @param key an <code>Object</code> value
     * @return the removed value, or null if it was not found in the map
     */
    @Override
    public Byte remove( Object key ) {
        if (! (key instanceof Long ) ) {
            return null;
        }
        long k = unwrapKey( key );
        if ( _map.containsKey( k ) ) {
            byte v = _map.remove( k );
            return wrapValue( v );
        }
        return null;
    }


    /**
     * Returns a Set view on the entries of the map.
     *
     * @return a <code>Set</code> value
     */
    @Override
    public Set<Entry<Long,Byte>> entrySet() {
        return new AbstractSet<Entry<Long,Byte>>() {
            @Override
            public int size() {
                return _map.size();
            }

            @Override
            public boolean isEmpty() {
                return TLongByteMapDecorator.this.isEmpty();
            }

            @Override
            public boolean contains( Object o ) {
                if (o instanceof Map.Entry) {
                    Object k = ( ( Entry ) o ).getKey();
                    Object v = ( ( Entry ) o ).getValue();
                    return TLongByteMapDecorator.this.containsKey(k)
                            && TLongByteMapDecorator.this.get(k).equals(v);
                } else {
                    return false;
                }
            }

            @Override
            public Iterator<Entry<Long,Byte>> iterator() {
                return new Iterator<Entry<Long,Byte>>() {
                    private final TLongByteIterator it = _map.iterator();

                    @Override
                    public Entry<Long,Byte> next() {
                        it.advance();
                        long ik = it.key();
                        final Long key =  wrapKey( ik );
                        byte iv = it.value();
                        final Byte v = wrapValue( iv );
                        return new Entry<Long,Byte>() {
                            private Byte val = v;

                            @Override
                            public boolean equals( Object o ) {
                                return o instanceof Map.Entry
                                        && ( ( Entry ) o ).getKey().equals(key)
                                        && ( ( Entry ) o ).getValue().equals(val);
                            }

                            @Override
                            public Long getKey() {
                                return key;
                            }

                            @Override
                            public Byte getValue() {
                                return val;
                            }

                            @Override
                            public int hashCode() {
                                return key.hashCode() + val.hashCode();
                            }

                            @Override
                            public Byte setValue( Byte value ) {
                                val = value;
                                return put( key, value );
                            }
                        };
                    }

                    @Override
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override
                    public void remove() {
                        it.remove();
                    }
                };
            }

            @Override
            public boolean add( Entry<Long,Byte> o ) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean remove( Object o ) {
                boolean modified = false;
                if ( contains( o ) ) {
                    //noinspection unchecked
                    Long key = ( ( Entry<Long,Byte> ) o ).getKey();
                    _map.remove( unwrapKey( key ) );
                    modified = true;
                }
                return modified;
            }

            @Override
            public boolean addAll( Collection<? extends Entry<Long, Byte>> c ) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void clear() {
                TLongByteMapDecorator.this.clear();
            }
        };
    }


    /**
     * Checks for the presence of <tt>val</tt> in the values of the map.
     *
     * @param val an <code>Object</code> value
     * @return a <code>boolean</code> value
     */
    @Override
    public boolean containsValue( Object val ) {
        return val instanceof Byte && _map.containsValue( unwrapValue( val ) );
    }


    /**
     * Checks for the present of <tt>key</tt> in the keys of the map.
     *
     * @param key an <code>Object</code> value
     * @return a <code>boolean</code> value
     */
    @Override
    public boolean containsKey( Object key ) {
        if ( key == null ) return _map.containsKey( _map.getNoEntryKey() );
        return key instanceof Long && _map.containsKey( unwrapKey( key ) );
    }


    /**
     * Returns the number of entries in the map.
     *
     * @return the map's size.
     */
    @Override
    public int size() {
        return this._map.size();
    }


    /**
     * Indicates whether map has any entries.
     *
     * @return true if the map is empty
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    /**
     * Copies the key/value mappings in <tt>map</tt> into this map.
     * Note that this will be a <b>deep</b> copy, as storage is by
     * primitive value.
     *
     * @param map a <code>Map</code> value
     */
    @Override
    public void putAll( Map<? extends Long, ? extends Byte> map ) {
        Iterator<? extends Entry<? extends Long,? extends Byte>> it =
            map.entrySet().iterator();
        for ( int i = map.size(); i-- > 0; ) {
            Entry<? extends Long,? extends Byte> e = it.next();
            this.put( e.getKey(), e.getValue() );
        }
    }


    /**
     * Wraps a key
     *
     * @param k key in the underlying map
     * @return an Object representation of the key
     */
    protected Long wrapKey( long k ) {
        return Long.valueOf( k );
    }


    /**
     * Unwraps a key
     *
     * @param key wrapped key
     * @return an unwrapped representation of the key
     */
    protected long unwrapKey( Object key ) {
        return ( ( Long ) key ).longValue();
    }


    /**
     * Wraps a value
     *
     * @param k value in the underlying map
     * @return an Object representation of the value
     */
    protected Byte wrapValue( byte k ) {
        return Byte.valueOf( k );
    }


    /**
     * Unwraps a value
     *
     * @param value wrapped value
     * @return an unwrapped representation of the value
     */
    protected byte unwrapValue( Object value ) {
        return ( ( Byte ) value ).byteValue();
    }


    // Implements Externalizable
    @Override
    public void readExternal( ObjectInput in )
        throws IOException, ClassNotFoundException {

        // VERSION
        in.readByte();

        // MAP
        _map = ( TLongByteMap ) in.readObject();
    }


    // Implements Externalizable
    @Override
    public void writeExternal( ObjectOutput out ) throws IOException {
        // VERSION
        out.writeByte(0);

        // MAP
        out.writeObject( _map );
    }

} // TLongByteHashMapDecorator
