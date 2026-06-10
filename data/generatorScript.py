import csv
import random
import time
from faker import Faker

fake = Faker()

# Vehicle pool: realistic IDs that repeat, not unique per row
vehicle_types = ["bus", "tram", "train"]
vehicle_ids = [f"{random.choice(vehicle_types)}_{i}" for i in range(1, 101)]  # 100 vehicles

# Routes: mostly numeric, some with letters, some empty for realism
route_ids = ["3", "5", "7", "12", "22", "5A", "N5", "B1", "", None]

# Base coordinates for a city (New York City in this case)
base_lat, base_lon = 40.7128, -74.0060

start_time = int(time.time()) - 86400  # 24 hours ago

with open("vehicles.csv", "w", newline="") as file:
    writer = csv.writer(file, lineterminator="\n")  # \n is fine for most systems
    writer.writerow(["vehicle_id", "latitude", "longitude", "timestamp", "route_id", "speed"])

    for i in range(100000):
        vehicle_id = random.choice(vehicle_ids)

        # Vehicles move in a realistic radius around the city center
        latitude = base_lat + random.uniform(-0.08, 0.08)
        longitude = base_lon + random.uniform(-0.08, 0.08)

        # Timestamps increment roughly every few seconds, simulating real pings
        timestamp = start_time + (i * random.randint(1, 15))

        route_id = random.choice(route_ids)

        # Speed: most values are normal, some are edge cases
        speed_roll = random.random()
        if speed_roll < 0.95:
            # Normal: 0 to 80 km/h
            speed = round(random.uniform(0, 80), 1)
        elif speed_roll < 0.97:
            # Sensor glitch: negative speed
            speed = round(random.uniform(-5, -0.1), 1)
        elif speed_roll < 0.99:
            # Very high speed (sensor error or emergency)
            speed = round(random.uniform(120, 250), 1)
        else:
            # Garbled: NaN equivalent in your parser
            speed = "N/A"

        writer.writerow([vehicle_id, latitude, longitude, timestamp, route_id, speed])

print("Generated 100,000 rows in vehicles.csv")