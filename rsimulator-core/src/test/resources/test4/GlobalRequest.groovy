vars.put "a", "b"
def request = vars.get("request")
vars.put("simulatorResponse", new org.rsimulator.core.SimulatorResponseImpl("Hello Test4, says GlobalRequest.groovy!", new java.util.Properties(), null))
