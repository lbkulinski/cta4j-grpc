package net.lbku.service;

import io.grpc.stub.StreamObserver;
import net.lbku.proto.Empty;
import net.lbku.proto.StationsResponse;
import org.springframework.stereotype.Service;
import net.lbku.proto.StationServiceGrpc;

@Service
public class StationService extends StationServiceGrpc.StationServiceImplBase {
    @Override
    public void getStations(Empty request, StreamObserver<StationsResponse> responseObserver) {
        super.getStations(request, responseObserver);
    }
}
