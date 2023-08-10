package com.course_project_autotrace;


import com.course_project_autotrace.TrafficViolations.TrafficViolationsModel;
import com.course_project_autotrace.TrafficViolations.TrafficViolationsPresenter;
import com.course_project_autotrace.TrafficViolations.TrafficViolationsView;
import com.google.firebase.database.DataSnapshot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class TrafficViolationsPresenterTest {

    @Mock
    TrafficViolationsModel model;

    @Mock
    TrafficViolationsView view;

    TrafficViolationsPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new TrafficViolationsPresenter(view, model);
    }

    @Test
    public void testFetchDataForDriver_withViolations() {
        DataSnapshot snapshot = mock(DataSnapshot.class);
        when(snapshot.exists()).thenReturn(true);

        doAnswer(invocation -> {
            TrafficViolationsModel.OnDataLoaded callback = invocation.getArgument(1);
            callback.onDataLoaded(snapshot);
            return null;
        }).when(model).fetchViolationsData(anyString(), any());

        presenter.fetchDataForDriver("testDriverLicense");
        verify(view).showTrafficViolationsData(snapshot);
    }

    @Test
    public void testFetchDataForDriver_noViolations() {
        doAnswer(invocation -> {
            TrafficViolationsModel.OnDataLoaded callback = invocation.getArgument(1);
            callback.onDataLoaded(null);
            return null;
        }).when(model).fetchViolationsData(anyString(), any());

        presenter.fetchDataForDriver("testDriverLicense");
        verify(view).showNoViolations();
    }

    @Test
    public void testFetchDataForDriver_onError() {
        doAnswer(invocation -> {
            TrafficViolationsModel.OnDataLoaded callback = invocation.getArgument(1);
            callback.onError("Some error");
            return null;
        }).when(model).fetchViolationsData(anyString(), any());

        presenter.fetchDataForDriver("testDriverLicense");
        verify(view).showError("Some error");
    }
}

