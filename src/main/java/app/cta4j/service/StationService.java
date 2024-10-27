package app.cta4j.service;

import app.cta4j.jooq.Tables;
import app.cta4j.proto.Station;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import app.cta4j.proto.Empty;
import app.cta4j.proto.StationsResponse;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.cta4j.proto.StationServiceGrpc;

import java.util.List;
import java.util.Objects;

@Service
public final class StationService extends StationServiceGrpc.StationServiceImplBase {
    private final DSLContext context;

    private static final Logger LOGGER;

    static {
        LOGGER = LoggerFactory.getLogger(StationService.class);
    }

    @Autowired
    public StationService(DSLContext context) {
        this.context = Objects.requireNonNull(context);
    }

    @Override
    public void getStations(Empty request, StreamObserver<StationsResponse> responseObserver) {
        List<Station> stations;

        try {
            stations = this.context.select(Tables.STATION.ID, Tables.STATION.NAME)
                                   .from(Tables.STATION)
                                   .fetch()
                                   .map(record -> {
                                       int id = record.get(Tables.STATION.ID);

                                       String name = record.get(Tables.STATION.NAME);

                                       return Station.newBuilder()
                                                     .setId(id)
                                                     .setName(name)
                                                     .build();
                                   });
        } catch (DataAccessException e) {
            String message = e.getMessage();

            StationService.LOGGER.error(message, e);

            StatusException internalException = new StatusException(Status.INTERNAL);

            responseObserver.onError(internalException);

            return;
        }

        StationsResponse response = StationsResponse.newBuilder()
                                                    .addAllStations(stations)
                                                    .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
