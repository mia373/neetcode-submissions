class TimeMap:

    def __init__(self):
        self.timemap = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.timemap.setdefault(key, []).append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        # Handle case where key doesn't exist
        if key not in self.timemap:
            return ""
            
        values = self.timemap[key]
        res = ""

        l, r = 0, len(values) - 1

        while l <= r:
            m = l + (r - l) // 2

            if values[m][0] <= timestamp:
                res = values[m][1]
                l = m + 1
            else:
                r = m - 1

        return res