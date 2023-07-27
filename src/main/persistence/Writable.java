package persistence;

import org.json.JSONObject;

// Code and corresponding tests inspired or directly used from:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public interface Writable {
    // EFFECTS: returns this as JSON Object
    JSONObject toJson();
}
