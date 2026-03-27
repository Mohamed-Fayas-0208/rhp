#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

class SegmentTree {
    vector<long long> segment;
    vector<long long> arr;
    long long len;
    long long size;

public:
    SegmentTree(vector<long long>& arr, long long n) {
        this->arr = arr;
        this->size = calculateSize(n);
        this->len = (size * 2);
        segment.resize(len, 0);
    }

    void build() {
        long long n = arr.size();

        for (long long i = size, ind = 0; ind < n; ind++, i++) {
            segment[i] = arr[ind];
        }

        for (long long i = size - 1; i > 0; i--) {
            long long left = 2 * i, right = 2 * i + 1;
            segment[i] = segment[left] + segment[right];
        }
    }

    long long calculateSize(long long n) {
        long long near = ceil(log2(n));
        return pow(2, near);
    }

    long long rangeSum(long long ind, long long left, long long right, long long leftQ, long long rightQ) {
        if (left >= leftQ && right <= rightQ) {
            return segment[ind];
        }
        if (right < leftQ || left > rightQ) return 0;

        long long mid = left + (right - left) / 2;

        long long l = rangeSum(ind * 2, left, mid, leftQ, rightQ);
        long long r = rangeSum(ind * 2 + 1, mid + 1, right, leftQ, rightQ);

        return l + r;
    }

    void update(long long pos, long long val) {
        segment[size + pos - 1] = val;

        long long par = (size + pos - 1) / 2;
        while (par > 0) {
            long long left = 2 * par, right = 2 * par + 1;
            segment[par] = segment[left] + segment[right];
            par /= 2;
        }
    }

    long long getSize() {
        return size;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long n, q;
    cin >> n >> q;
    vector<long long> arr(n);

    for (long long i = 0; i < n; i++) cin >> arr[i];
    SegmentTree seg(arr, arr.size());

    seg.build();

    for (long long i = 0; i < q; i++) {
        long long type, a, b;
        cin >> type >> a >> b;
        if (type == 2) {
            cout << seg.rangeSum(1, 1, seg.getSize(), a, b) << '\n';
        } else {
            seg.update(a, b);
        }
    }

    return 0;
}