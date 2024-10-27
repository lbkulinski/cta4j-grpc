/*
 * This file is generated by jOOQ.
 */
package app.cta4j.jooq.tables.records;


import app.cta4j.jooq.tables.RouteDirection;
import org.jooq.Record2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class RouteDirectionRecord extends UpdatableRecordImpl<RouteDirectionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.route_direction.route_id</code>.
     */
    public void setRouteId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.route_direction.route_id</code>.
     */
    public String getRouteId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.route_direction.direction_id</code>.
     */
    public void setDirectionId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.route_direction.direction_id</code>.
     */
    public Integer getDirectionId() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RouteDirectionRecord
     */
    public RouteDirectionRecord() {
        super(RouteDirection.ROUTE_DIRECTION);
    }

    /**
     * Create a detached, initialised RouteDirectionRecord
     */
    public RouteDirectionRecord(String routeId, Integer directionId) {
        super(RouteDirection.ROUTE_DIRECTION);

        setRouteId(routeId);
        setDirectionId(directionId);
        resetChangedOnNotNull();
    }
}
