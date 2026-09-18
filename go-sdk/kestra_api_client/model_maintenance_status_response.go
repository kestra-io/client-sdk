package kestra_api_client

// MaintenanceStatusResponse is the payload of GET /api/v1/instance/maintenance/status.
type MaintenanceStatusResponse struct {
	// Maintenance reports whether maintenance mode is currently enabled.
	Maintenance bool `json:"maintenance"`
	// Ready reports whether every service has reached the MAINTENANCE state, i.e.
	// the instance is safe to update.
	Ready bool `json:"ready"`
	// Services is a per-service-type breakdown of how many instances have reached
	// the MAINTENANCE state versus the total running.
	Services map[ServiceType]MaintenanceServiceStatus `json:"services,omitempty"`
}

// GetMaintenance returns the Maintenance field.
func (o *MaintenanceStatusResponse) GetMaintenance() bool { return o.Maintenance }

// GetReady returns the Ready field.
func (o *MaintenanceStatusResponse) GetReady() bool { return o.Ready }

// GetServices returns the Services field.
func (o *MaintenanceStatusResponse) GetServices() map[ServiceType]MaintenanceServiceStatus {
	return o.Services
}

// MaintenanceServiceStatus is the maintenance breakdown for a single service type.
type MaintenanceServiceStatus struct {
	// Total is the total number of running instances of this service type.
	Total int32 `json:"total"`
	// InMaintenance is the number of instances that have reached MAINTENANCE state.
	InMaintenance int32 `json:"inMaintenance"`
}

// GetTotal returns the Total field.
func (o *MaintenanceServiceStatus) GetTotal() int32 { return o.Total }

// GetInMaintenance returns the InMaintenance field.
func (o *MaintenanceServiceStatus) GetInMaintenance() int32 { return o.InMaintenance }
