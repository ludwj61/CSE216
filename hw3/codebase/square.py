from .rectangle import Rectangle
from .quadrilateral import Quadrilateral
from .two_d_point import TwoDPoint


class Square(Rectangle):

    def __init__(self, *floats):
        super().__init__(*floats)
        if not self.__is_member():
            raise TypeError("A square cannot be formed by the given coordinates.")

    @staticmethod
    def round_point(point): # Added by me as a helper
        return TwoDPoint(round(point.x), round(point.y))

    def snap(self):
        """Snaps the sides of the square such that each corner (x,y) is modified to be a corner (x',y') where x' is the
        integer value closest to x and y' is the integer value closest to y. This, of course, may change the shape to a
        general quadrilateral, hence the return type. The only exception is when the square is positioned in a way where
        this approximation will lead it to vanish into a single point. In that case, a call to snap() will not modify
        this square in any way."""
        verts = map(self.round_point, self.vertices) # TODO finish this
        return Quadrilateral()  # TODO
