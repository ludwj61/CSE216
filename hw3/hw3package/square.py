from .rectangle import Rectangle
from .quadrilateral import Quadrilateral
from .two_d_point import TwoDPoint
import math


class Square(Rectangle):
    def __init__(self, *floats):
        super().__init__(*floats)
        if not self.__is_member():
            raise TypeError("A square cannot be formed by the given coordinates.")

    def __is_member(self):  # added by me to fix error
        verts = self.vertices
        for v in range(0, 4):
            for v2 in range(0, 4):
                if v != v2:
                    if verts[v] == verts[v2]:
                        return False

        if (
            verts[0].y != verts[1].y
            or verts[0].x != verts[3].x
            or verts[1].x != verts[2].x
            or verts[2].y != verts[3].y
        ):
            return False

        lengths = self.side_lengths()
        return lengths[0] == lengths[1] == lengths[2] == lengths[3]

    @staticmethod
    def __verts_to_floats(points):  # helper added by me
        raw_values = []
        for p in points:
            raw_values.append(p.x)
            raw_values.append(p.y)
        return raw_values

    @staticmethod
    # Added by me as a helper, to make a copy of a quad without a new constructor
    def __from_verts_quad(points):
        raw_values = Square.__verts_to_floats(points)
        return Quadrilateral(*tuple(raw_values))

    @staticmethod
    # Added by me as a helper, to make a copy of a square without a new constructor
    def __from_verts_square(points):
        raw_values = Square.__verts_to_floats(points)
        return Square(*tuple(raw_values))

    @staticmethod
    def my_round(num): # Added by me as helper
        if num < 0 and num % 1 >= .6:
            return math.ceil(num - 0.5)
        else:
            return math.floor(num + 0.5)

    @staticmethod
    def round_point(point):  # Added by me as a helper
        return TwoDPoint(Square.my_round(point.x), Square.my_round(point.y))

    def snap(self):
        """Snaps the sides of the square such that each corner (x,y) is modified to be a corner (x',y') where x' is the
        integer value closest to x and y' is the integer value closest to y. This, of course, may change the shape to a
        general quadrilateral, hence the return type. The only exception is when the square is positioned in a way where
        this approximation will lead it to vanish into a single point. In that case, a call to snap() will not modify
        this square in any way."""
        verts_round = list(map(self.round_point, self.vertices))

        if verts_round[0] == verts_round[1] == verts_round[2] == verts_round[3]:
            return Square.__from_verts_quad(self.vertices)

        return Square.__from_verts_square(verts_round)  # was TODO

    def __eq__(self, shape):  # implemented by me
        if type(self) != type(shape):
            return False
        for i in range(0, 4):
            if self.vertices[i] != shape.vertices[i]:
                return False
        return True

    def __str__(self):  # implemented by me
        verts_str = str(self.vertices[0])
        for v in self.vertices[1:]:
            verts_str += "; "
            verts_str += str(v)
        return self.__class__.__name__ + ": " + verts_str + ", All sides equal length"
