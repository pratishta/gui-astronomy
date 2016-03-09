package gui.astronomy.api;

public class JsonLocation {
    private JsonLocation.results[] results;
    private String status;

    public JsonLocation() {
    }

    public String getLat() {
        return this.results.length > 0?this.results[0].getGeometry().getLocation().getLat():"";
    }

    public String getLng() {
        return this.results.length > 0?this.results[0].getGeometry().getLocation().getLng():"";
    }

    public String getStatus() {
        return this.status;
    }

    private class results {
        private JsonLocation.results.geometry geometry;

        private results() {
        }

        public JsonLocation.results.geometry getGeometry() {
            return this.geometry;
        }

        private class geometry {
            private JsonLocation.results.geometry.location location;

            private geometry() {
            }

            public JsonLocation.results.geometry.location getLocation() {
                return this.location;
            }

            private class location {
                public String lat;
                public String lng;

                private location() {
                }

                public String getLat() {
                    return this.lat;
                }

                public String getLng() {
                    return this.lng;
                }
            }
        }
    }
}
