package run.halo.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import run.halo.app.model.entity.Category;
import run.halo.app.model.entity.Post;
import run.halo.app.model.entity.PostCategory;
import run.halo.app.service.base.CrudService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Post category service interface.
 *
 * @author johnniang
 * @date 3/19/19
 */
public interface PostCategoryService extends CrudService<PostCategory, Integer> {

    /**
     * Lists category by post id.
     *
     * @param postId post id must not be null
     * @return a list of category
     */
    @NonNull
    List<Category> listCategoryBy(@NonNull Integer postId);

    /**
     * List category list map by post id collection.
     *
     * @param postIds post id collection
     * @return a category list map (key: postId, value: a list of category)
     */
    @NonNull
    Map<Integer, List<Category>> listCategoryListMap(@Nullable Collection<Integer> postIds);

    /**
     * Lists post by category id.
     *
     * @param categoryId category id must not be null
     * @return a list of post
     */
    @NonNull
    List<Post> listPostBy(@NonNull Integer categoryId);

    /**
     * Pages post by category slug name.
     *
     * @param categoryId category id must not be null
     * @param pageable   pageable
     * @return page of post
     */
    @NonNull
    Page<Post> pagePostBy(@NonNull Integer categoryId, Pageable pageable);

    /**
     * Merges or creates post categories by post id and category id set if absent.
     *
     * @param postId      post id must not be null
     * @param categoryIds category id set
     * @return a list of post category
     */
    @NonNull
    List<PostCategory> mergeOrCreateByIfAbsent(@NonNull Integer postId, @Nullable Set<Integer> categoryIds);

    /**
     * Lists by post id.
     *
     * @param postId post id must not be null
     * @return a list of post category
     */
    @NonNull
    List<PostCategory> listByPostId(@NonNull Integer postId);

    /**
     * Lists by category id.
     *
     * @param categoryId category id must not be null
     * @return a list of post category
     */
    @NonNull
    List<PostCategory> listByCategoryId(@NonNull Integer categoryId);

    /**
     * List category id set by post id.
     *
     * @param postId post id must not be null
     * @return a set of category id
     */
    @NonNull
    Set<Integer> listCategoryIdsByPostId(@NonNull Integer postId);

    /**
     * Removes post categories by post id.
     *
     * @param postId post id must not be null
     * @return a list of post category deleted
     */
    @NonNull
    List<PostCategory> removeByPostId(@NonNull Integer postId);

    /**
     * Removes post categories by category id.
     *
     * @param categoryId category id must not be null
     * @return a list of post category deleted
     */
    @NonNull
    List<PostCategory> removeByCategoryId(@NonNull Integer categoryId);
}
